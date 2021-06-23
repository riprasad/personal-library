package dev.rishab.library.resource;

import dev.rishab.library.beans.AddSeries;
import dev.rishab.library.beans.Series;
import dev.rishab.library.entity.Book;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/series")
public interface SeriesResource {
  /**
   * Returns a list of all book series in the library.
   */
  @GET
  @Produces("application/json")
  List<Series> listSeries();

  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Series addSeries(AddSeries data);

  @Path("/{seriesId}")
  @GET
  @Produces("application/json")
  Series getSeries(@PathParam("seriesId") int seriesId);

  @Path("/{seriesId}")
  @DELETE
  void deleteSeries(@PathParam("seriesId") int seriesId);

  @Path("/{seriesId}/books")
  @GET
  @Produces("application/json")
  List<Book> getBooksInSeries(@PathParam("seriesId") int seriesId);
}
