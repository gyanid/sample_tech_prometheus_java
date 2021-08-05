package com.jacace.observability.servicegraph;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import org.springframework.data.domain.PageRequest;
import io.prometheus.client.Counter;
import io.prometheus.client.CollectorRegistry;

@Controller
@RequestMapping(path = "/servicegraph")
public class ServiceGraphController {

    private final Counter requestCount;
    private static final String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    // @Autowired
    // SrvService srvService;
    private ServiceRepository serviceRepository;

    public ServiceGraphController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
        CollectorRegistry collectorRegistry=CollectorRegistry.defaultRegistry;
        requestCount = Counter.build().name("cur_date_req_call").help("Number of cur date requests").register(collectorRegistry);
    }

    @GetMapping()
    //public @ResponseBody Flux<Service> get() {
    public @ResponseBody Service get() {
        requestCount.inc();
        Date curDate = new Date();
        SimpleDateFormat outputFormat = new SimpleDateFormat(dateTimeFormat);

        Service objSrv = new Service();
        objSrv.setName(outputFormat.format(curDate));
        return objSrv;
    }

    @PostMapping()
    public ResponseEntity<Flux<Service>> getAllAuthors(@RequestParam(name = "limit", defaultValue = "20") Integer limit,
            @RequestParam(name = "offset", defaultValue = "0") Integer offset) {
        // return ResponseEntity.ok(srvService.getAllServices(offset, limit));
        return ResponseEntity.ok(this.serviceRepository.retrieveAllAuthors(PageRequest.of(offset, limit)));
    }

}
