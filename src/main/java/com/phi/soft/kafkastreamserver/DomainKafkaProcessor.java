package com.phi.soft.kafkastreamserver;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@Configurable
public class DomainKafkaProcessor {

    @Bean
    public Function<KStream<String,Domain>, KStream<String,Domain>> domainProcessor(){

        return kstream->kstream.filter((key,domain)->{
            if(domain.isDead){
                System.out.println("Inactive domain : "+ domain.getDomain());
            }else {
                System.out.println("Active domain : "+domain.getDomain());
            }
            return !domain.isDead;
        });
    }
}
