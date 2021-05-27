package eu._5gzorro.manager.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu._5gzorro.manager.api.dto.requests.PublishProductOfferingRequest;
import eu._5gzorro.manager.api.dto.requests.UpdateProductOfferingRequest;
import eu._5gzorro.manager.api.service.ProductOfferingService;
import eu._5gzorro.manager.service.ProductOfferingDriver;
import eu._5gzorro.tm_forum.models.product.ProductOffering;
import eu._5gzorro.tm_forum.models.product.ProductSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductOfferingController.class)
public class ProductOfferingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductOfferingDriver productOfferingDriver;

  @MockBean
  private ProductOfferingService productOfferingService;

  private ObjectMapper objectMapper = new ObjectMapper()
      .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

  @Test
  public void testPublishProductOffering() throws Exception {
    PublishProductOfferingRequest request = new PublishProductOfferingRequest()
        .setProductOffering(new ProductOffering())
        .setProductSpecification(new ProductSpecification())
        .setProductOfferingPrices(emptyList())
        .setResourceSpecifications(emptyList())
        .setServiceSpecifications(emptyList())
        .setDid("someDid")
        .setInvitations(Collections.emptyMap())
        .setVerifiableCredentials(null);

    MvcResult mvcResult = mockMvc
        .perform(MockMvcRequestBuilders.post("/product-offer")
        .content(objectMapper.writeValueAsBytes(request))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();

    Boolean result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Boolean.class);
    assertNotNull(result);
    assertThat(result, Matchers.is(true));
  }

  @Test
  public void testRemoveProductOffering() throws Exception {
    MvcResult mvcResult = mockMvc
        .perform(MockMvcRequestBuilders
            .delete("/product-offer/12343")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andReturn();

    Boolean result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Boolean.class);
    assertNotNull(result);
    assertThat(result, Matchers.is(true));
  }

  @Test
  public void testUpdateProductOffering() throws Exception {
    UpdateProductOfferingRequest request = new UpdateProductOfferingRequest()
        .setProductOffering(new ProductOffering())
        .setProductSpecification(new ProductSpecification())
        .setProductOfferingPrices(emptyList())
        .setResourceSpecifications(emptyList())
        .setServiceSpecifications(emptyList())
        .setDid("someDid")
        .setInvitations(Collections.emptyMap());

    MvcResult mvcResult = mockMvc
        .perform(MockMvcRequestBuilders
            .put("/product-offer/12343")
            .content(objectMapper.writeValueAsBytes(request))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andReturn();

    Boolean result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Boolean.class);
    assertNotNull(result);
    assertThat(result, Matchers.is(true));
  }
}
