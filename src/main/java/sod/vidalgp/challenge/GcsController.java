package sod.vidalgp.challenge;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.WritableResource;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GcsController {

  @RequestMapping(value = "/processDataBlob", method = RequestMethod.POST, consumes="application/json")
    public String processData(@RequestBody BlobKey blobKey) throws Exception {

      DataHandler.processData(blobKey.getSrc());

      return blobKey.toString();
    }
}