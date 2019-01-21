package com.libraryapp.library;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WireMockTest {

    static WireMockServer wireMockServer;

    @BeforeAll
    static void setUpAll() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();
    }

    @AfterAll
    static void tearDownAll() {
        wireMockServer.stop();
    }

    @BeforeEach
    static void beforEach() {
        WireMock.reset();
    }

    @Test
    void basicStub() {
        //given
        WireMock.stubFor((WireMock.get(WireMock.urlPathEqualTo("/all")).willReturn(WireMock.aResponse()
                .withStatus(200)
        )));

    }

}
