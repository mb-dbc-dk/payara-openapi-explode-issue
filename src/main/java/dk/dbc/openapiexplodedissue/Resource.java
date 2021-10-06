package dk.dbc.openapiexplodedissue;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.time.Instant;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.enums.Explode;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;

@Path("ping")
public class Resource {

    @GET
    @Parameters({
        @Parameter(name = "name", description = "The name(s)", required = false,
                   schema = @Schema(type = SchemaType.ARRAY, implementation = String.class),
                   explode = Explode.TRUE)
    })
    public Response ping(@QueryParam("name") List<String> names) {
        System.out.println("names = " + names);
        return Response.ok(Instant.now().toString()).build();
    }
}
