package com.jacace.observability.servicegraph;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="service")
public class Service {
    @Id
	private String id;
    @TextIndexed
    private String name;
    private String portNumber;
    private String endPointURL;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
