package com.github.hotire.spring.rest.docs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BaseController.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "api.hotire.com")
class BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/base/{name}", "hotire"))
               .andExpect(status().isOk())
               .andDo(document("base", pathParameters(parameterWithName("name").description("The name of entity"))));
    }



}