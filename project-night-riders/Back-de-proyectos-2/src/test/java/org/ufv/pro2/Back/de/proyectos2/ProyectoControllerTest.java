package org.ufv.pro2.Back.de.proyectos2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProyectoControllerTest {
    private ProyectoController proyectoController;
    private MockMvc mockMvc;

    @BeforeEach
    void Inicializar() {
        proyectoController = new ProyectoController();
        mockMvc = MockMvcBuilders.standaloneSetup(proyectoController).build();
    }

    @Test
    @DisplayName("Test GetMapping producto")//Test que comprueba solicitud HTTP
    public void Producto() throws Exception {
        mockMvc.perform(get("/productos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    @DisplayName("Test GetMapping Valoraciones")//Test que comprueba solicitud HTTP
    public void Valoraciones() throws Exception {
        mockMvc.perform(get("/valoraciones"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    @DisplayName("Test GetMapping UltimosPuntos")//Test que comprueba solicitud HTTP
    public void UltimosPuntos() throws Exception {
        mockMvc.perform(get("/ultimosPuntos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    


}
