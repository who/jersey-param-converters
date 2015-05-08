package sk.dejavu.blog.examples.paramconverters.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import sk.dejavu.blog.examples.paramconverters.model.Entity;

/**
 * @author Michal Gajdos
 */
@Path("json-param-converter")
@Produces("application/json")
@Api(value = "JsonParamConverterResource")
public class JsonParamConverterResource {

    @GET
    @Path("query")
    @ApiOperation(value = "getViaQueryParam")
    public Entity getViaQueryParam(
            @QueryParam("entity")
            @DefaultValue("{\"Entity\":{\"foo\":\"bar\",\"bar\":\"foo\"}}")
            final Entity entity) {
        return entity;
    }

    @GET
    @Path("header")
    @ApiOperation(value = "getViaHeaderParam")
    public Entity getViaHeaderParam(@HeaderParam("Entity") final Entity entity) {
        return entity;
    }
}
