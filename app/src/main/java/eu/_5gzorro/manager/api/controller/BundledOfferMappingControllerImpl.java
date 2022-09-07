package eu._5gzorro.manager.api.controller;

import eu._5gzorro.manager.api.model.entity.BundledOfferMapping;
import eu._5gzorro.manager.api.model.exception.BundledOfferMappingExistsException;
import eu._5gzorro.manager.api.model.exception.BundledOfferMappingNotFoundException;
import eu._5gzorro.manager.api.service.BundledOfferMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BundledOfferMappingControllerImpl implements BundledOfferMappingController {

    private BundledOfferMappingService bundledOfferMappingService;

    @Autowired
    public BundledOfferMappingControllerImpl(BundledOfferMappingService bundledOfferMappingService) {
        this.bundledOfferMappingService = bundledOfferMappingService;
    }

    @Override
    public ResponseEntity<?> saveBundledOfferMapping(BundledOfferMapping bundledOfferMapping)
            throws BundledOfferMappingExistsException {
        bundledOfferMappingService.save(bundledOfferMapping);
        return ResponseEntity.status(HttpStatus.CREATED).body(bundledOfferMapping);
    }

    @Override
    public ResponseEntity<?> getBundledOfferMappings() {
        return ResponseEntity.ok(bundledOfferMappingService.list());
    }

    @Override
    public ResponseEntity<?> getBundledOfferMapping(String bundleOfferDID)
            throws BundledOfferMappingNotFoundException {
        return ResponseEntity.ok(bundledOfferMappingService.getByBundleOfferDID(bundleOfferDID));
    }

    @Override
    public ResponseEntity<?> deleteBundledOfferMapping(String bundleOfferDID)
            throws BundledOfferMappingNotFoundException {
        bundledOfferMappingService.delete(bundleOfferDID);
        return ResponseEntity.noContent().build();
    }
}
