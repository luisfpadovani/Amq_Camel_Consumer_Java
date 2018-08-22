package br.com.fiap.consumer.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:FILA.TRABALHO.FIAP").process(new Processor() { 
            public void process(Exchange e) {
                System.out.println("Received exchange: " + e.getIn());
            }
        });
    }

}