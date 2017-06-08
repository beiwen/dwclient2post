package gomapapirest;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import gomapapirest.resources.MyPostResource;
import gomapapirest.resources.Client2Post;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Client2PostApplication extends Application<Client2PostConfiguration> {
    public static void main(String[] args) throws Exception {
        new Client2PostApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<Client2PostConfiguration> bootstrap) {
        bootstrap.addBundle(new MultiPartBundle());
    }

    @Override
    public void run(Client2PostConfiguration configuration,
                    Environment environment) throws Exception {
        
        environment.jersey().register(MultiPartFeature.class);
        
        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration()).build(getName());
        
        environment.jersey().register(new Client2Post(client));           
        
        environment.jersey().register(new MyPostResource()); 
        
            
    }

}
