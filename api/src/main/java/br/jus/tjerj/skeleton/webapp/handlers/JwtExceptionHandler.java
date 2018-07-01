package br.jus.tjerj.skeleton.webapp.handlers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.jus.tjerj.skeleton.webapp.utils.response.ExceptionResponse;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;

public class JwtExceptionHandler extends OncePerRequestFilter {

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			filterChain.doFilter(request, response);
		} 
		catch (MalformedJwtException ex) {
			this.handleMalformedJwtException(ex, response);
		} 	
		catch (JwtException ex) {
			this.handleJwtException(ex, response);
		}catch(Exception ex) {
			this.handleException(ex, response);
		} 
	}

	private void handle(String message, Class<?> clazz, HttpServletResponse response) throws IOException {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), message,
				clazz.getSimpleName());
		String json = new ObjectMapper().writeValueAsString(exceptionResponse);
		response.setContentType(MediaType.APPLICATION_JSON.toString());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.getWriter().write(json);
	}
	
	private final void handleMalformedJwtException(MalformedJwtException ex, HttpServletResponse response) throws IOException {
		this.handle("Token JWT incorreto.", ex.getClass() , response);
	}

	private final void handleJwtException(JwtException ex, HttpServletResponse response) throws IOException {
		this.handle("Erro no JWT.", ex.getClass() , response);
	}
	
	private final void handleException(Exception ex, HttpServletResponse response) throws IOException {
		this.handle("Erro.", ex.getClass() , response);
	}
}