package eu._5gzorro.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu._5gzorro.controller.dto.PublishProductOfferingRequest;
import eu._5gzorro.controller.dto.UpdateProductOfferingRequest;
import eu._5gzorro.lifecycle.manager.domain.ProductOffering;
import java.util.Collections;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductOfferingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private ObjectMapper objectMapper = new ObjectMapper()
      .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

  @Test
  public void testPublishProductOffering() throws Exception {
    PublishProductOfferingRequest request = new PublishProductOfferingRequest()
        .setProductOffering(new ProductOffering())
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
        .setInvitations(Collections.emptyMap())
        .setVerifiableCredentials(null);

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
