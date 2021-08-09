# Sample app to showcase prometheus java client libraries #

## Introduction ##
To scrap from prometheus and from this app use the command:

docker run -p 9090:9090 -v /path/to/file/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus

Note:
localhost and/or 127.0.0.1 are not recognized, use the IP address instead (see: https://github.com/grafana/grafana/issues/14629)

## Sample metrics ##

Examples to run in the expressions interface or graphs tab.

### Metrics that Prometheus exports about itself ###

* Amount of time between target scrapes:
          * prometheus_target_interval_length_seconds
* Count the number of returned time series: 
          * count(prometheus_target_interval_length_seconds)
* To graph the per-second rate of chunks being created in the self-scraped: 
          * rate(prometheus_tsdb_head_chunks_created_total[1m])
* Other examples: 
          * avg by (job, instance, mode) (rate(node_cpu_seconds_total[5m]))

## Springboot support for metrics ##
A meter is the interface for collecting a set of measurements (which we individually call metrics) about your application. spring-metrics packs with a supported set of Meter primitives including: Timer, Counter, Gauge, DistributionSummary, and LongTaskTimer

### @Timed annotation ###
Adding  to the controller creates a Timer time series named http_server_requests which by default contains dimensions for the HTTP status of the response, HTTP method, exception type if the request fails, and the pre-variable substitution parameterized endpoint URI.
Metrics will be published for JVM GC metrics.
If you are using logback, counts will be collected for log events at each level.




