package Voll.med.Primeira.Api.controller;

import Voll.med.Primeira.Api.domain.consultas.AgendamentoDeConsulta;
import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;
import Voll.med.Primeira.Api.domain.consultas.DetalhamentoDaConsulta;
import Voll.med.Primeira.Api.domain.medicos.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;



@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoDeConsulta> dadosAgendamentoDeConsultaJson;

    @Autowired
    private JacksonTester<DetalhamentoDaConsulta> detalhamentoDaConsulta;


    @Test
    @DisplayName("Deveria devolver o codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void agendamento_cenario1() throws Exception {
        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @MockBean
    private AgendamentoDeConsulta agendamentoDeConsulta;


    @Test
    @DisplayName("Deveria devolver o codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void agendamento_cenario2() throws Exception {
        var data = LocalDateTime.now().plusHours(1);
        var especialidade = Especialidade.Cardiologia;

        var dadosDetalhamento = new DetalhamentoDaConsulta(null, 2l, 5l, data);

        when(agendamentoDeConsulta.Agendamento(any())).thenReturn(dadosDetalhamento);

        var response = mvc.perform(
                post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosAgendamentoDeConsultaJson.write(new DadosAgendamentoDeConsulta(null,2l,5l,data,especialidade)
                        ).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = detalhamentoDaConsulta.write(dadosDetalhamento).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}