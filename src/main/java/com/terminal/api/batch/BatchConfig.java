package com.terminal.api.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	
	public Job job(JobBuilderFactory jobBuilderFactory, Step step1) {
	    return jobBuilderFactory.get("job")
	            .incrementer(new RunIdIncrementer())
	            .start(step1)
	            .build();
	}
    
    public Step step1(StepBuilderFactory stepBuilderFactory, 
                      ItemReader<String> reader, 
                      ItemProcessor<String, String> processor, 
                      ItemWriter<String> writer) {
        return stepBuilderFactory.get("step1")
                .<String, String>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemReader<String> reader() {
        List<String> data = Arrays.asList("data1", "data2", "data3");
        return new ListItemReader<>(data);
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        return item -> {
            // Procesamiento del dato (si es necesario)
            return item.toUpperCase(); // Ejemplo de procesamiento
        };
    }

    @Bean
    public ItemWriter<String> writer(RestTemplate restTemplate) {
        return items -> {
            for (String item : items) {
                String url = "http://example.com/api/endpoint"; // URL del servicio web
                restTemplate.postForObject(url, item, String.class);
            }
        };
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
