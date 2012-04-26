package br.org.quiz.tests.database.jpa;

import junit.framework.Assert;

import org.junit.Test;

import br.org.quiz.database.jpa.PersistenceConnection;

public class TestConnect {

	
	@Test
	public void testConnect() {
		
		PersistenceConnection conn = PersistenceConnection.getInstance();
		Assert.assertNotNull(conn);
	}
}
