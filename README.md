Sample app to showcase prometheus java client libraries

To scrap from prometheus and from this app us ethe command:

docker run -p 9090:9090 -v /Users/jacace/Desktop/src/sample_tech_observability_java/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus

Sample metrics:
(to run in teh expressions interface)
Metrics that Prometheus exports about itself:
prometheus_target_interval_length_seconds: the actual amount of time between target scrapes
count(prometheus_target_interval_length_seconds) : count the number of returned time series

(to run in the graphs tab)
 To graph the per-second rate of chunks being created in the self-scraped Prometheus: rate(prometheus_tsdb_head_chunks_created_total[1m])

 avg by (job, instance, mode) (rate(node_cpu_seconds_total[5m]))

-About the OOTB support with Springboot:
 A meter is the interface for collecting a set of measurements (which we individually call metrics) about your application. spring-metrics packs with a supported set of Meter primitives including: Timer, Counter, Gauge, DistributionSummary, and LongTaskTimer

 Adding @Timed to the controller creates a Timer time series named http_server_requests which by default contains dimensions for the HTTP status of the response, HTTP method, exception type if the request fails, and the pre-variable substitution parameterized endpoint URI.

Metrics will be published for JVM GC metrics.
If you are using logback, counts will be collected for log events at each level.




