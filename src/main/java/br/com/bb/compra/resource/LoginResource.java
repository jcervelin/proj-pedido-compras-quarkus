package br.com.bb.compra.resource;

import br.com.bb.compra.model.Cliente;
import br.com.bb.compra.model.login.LoginDto;
import br.com.bb.compra.model.login.TokenDto;
import br.com.bb.compra.security.JwtUtils;
import br.com.bb.compra.security.PasswordUtils;
import br.com.bb.compra.service.ClienteService;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Named;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;
import java.util.Set;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/login")
public class LoginResource {

    @Named("clienteServiceImpl")
    ClienteService clienteService;

    public LoginResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(description = "Realizar login")
    @POST
    public Response salvar(@Valid LoginDto loginDto) {
        return null;
    }

}
