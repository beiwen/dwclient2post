package gomapapirest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature; 

@Produces(MediaType.TEXT_PLAIN)
@Path("/client")
public class Client2Post {

    private Client client;

    public Client2Post(Client client) {
        this.client = client;

    }
    
    @GET
    @Path("/test")
    public String testPost() {

        
        final Invocation.Builder request = client.target("http://localhost:8080/testpost").register(MultiPartFeature.class).request();
  
        
        final FormDataMultiPart entity = new FormDataMultiPart()
                .field("foo", "bar");
        
        final String response = request.post(Entity.entity(entity, entity.getMediaType()), String.class);
        
        return response;

    }

}
