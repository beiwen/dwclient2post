package gomapapirest.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.codahale.metrics.annotation.Timed;


@Path("/testpost")

public class MyPostResource {

    public MyPostResource() {
        
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Timed
    public String test(
            @FormDataParam("foo") String testData) throws IOException {

        return testData;
    }

   

}
