package eu._5gzorro.manager.api.service;

import eu._5gzorro.manager.api.model.entity.BundledOfferMapping;
import eu._5gzorro.manager.api.model.exception.BundledOfferMappingExistsException;
import eu._5gzorro.manager.api.model.exception.BundledOfferMappingNotFoundException;
import eu._5gzorro.manager.api.repository.BundledOfferMappingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BundledOfferMappingService {

    private static final Logger log = LoggerFactory.getLogger(BundledOfferMappingService.class);

    private BundledOfferMappingRepository bundledOfferMappingRepository;

    @Autowired
    public BundledOfferMappingService(BundledOfferMappingRepository bundledOfferMappingRepository) {
        this.bundledOfferMappingRepository = bundledOfferMappingRepository;
    }

    public void save(BundledOfferMapping bundledOfferMapping) throws BundledOfferMappingExistsException {
        String bundleOfferDID = bundledOfferMapping.getBundleOfferDID();

        Optional<BundledOfferMapping> optionalBundledOfferMapping =
                bundledOfferMappingRepository.findByBundleOfferDID(bundleOfferDID);
        if(optionalBundledOfferMapping.isPresent()) {
            String msg = "Bundled Offer Mapping already exists for Bundle Offer DID " + bundleOfferDID + ".";
            log.info(msg);
            throw new BundledOfferMappingExistsException(msg);
        }

        log.info("Saving Bundled Order DIDs for Bundle Offer DID {}.", bundleOfferDID);

        bundledOfferMappingRepository.save(bundledOfferMapping);

        log.info("Bundled Order DIDs for Bundle Offer DID {} saved.", bundleOfferDID);
    }

    public List<BundledOfferMapping> list() {
        log.info("Retrieving Bundled Offer Mappings.");

        List<BundledOfferMapping> bundledOfferMappings = bundledOfferMappingRepository.findAll();

        log.info("Bundled Offer Mappings retrieved.");

        return bundledOfferMappings;
    }

    public BundledOfferMapping getByBundleOfferDID(String bundleOfferDID) throws BundledOfferMappingNotFoundException {
        log.info("Retrieving Bundled Offer Mapping for Bundle Offer DID {}.", bundleOfferDID);

        Optional<BundledOfferMapping> optionalBundledOfferMapping =
                bundledOfferMappingRepository.findByBundleOfferDID(bundleOfferDID);
        if(!optionalBundledOfferMapping.isPresent()) {
            String msg = "Bundled Offer Mapping for Bundle Offer DID " + bundleOfferDID + " not found.";
            log.info(msg);
            throw new BundledOfferMappingNotFoundException(msg);
        }

        log.info("Bundled Offer Mapping for Bundle Offer DID {} retrieved.", bundleOfferDID);

        return optionalBundledOfferMapping.get();
    }

    public void delete(String bundleOfferDID) throws BundledOfferMappingNotFoundException {
        log.info("Removing Bundled Offer Mapping for Bundle Offer DID {}.", bundleOfferDID);

        Optional<BundledOfferMapping> optionalBundledOfferMapping =
                bundledOfferMappingRepository.findByBundleOfferDID(bundleOfferDID);
        if(!optionalBundledOfferMapping.isPresent()) {
            String msg = "Bundled Offer Mapping for Bundle Offer DID " + bundleOfferDID + " not found.";
            log.info(msg);
            throw new BundledOfferMappingNotFoundException(msg);
        }

        bundledOfferMappingRepository.delete(optionalBundledOfferMapping.get());

        log.info("Bundled Offer Mapping for Bundle Offer DID {} removed.", bundleOfferDID);
    }
}
