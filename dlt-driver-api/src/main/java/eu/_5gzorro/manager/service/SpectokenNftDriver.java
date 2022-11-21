package eu._5gzorro.manager.service;

import eu._5gzorro.tm_forum.models.spectoken.NftDto;
import eu._5gzorro.tm_forum.models.spectoken.NftResponse;

import java.util.List;

public interface SpectokenNftDriver {

    List<NftResponse> getNftResponses();

    List<NftDto> getNftDtos();
}
