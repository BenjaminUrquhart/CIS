package net.benjaminurquhart.CIO.input;

import java.io.IOException;

import net.dv8tion.jda.core.entities.User;

interface Listener {

	int getNext() throws IOException;
	User getLatestUser();
	boolean isDeleted();
	int available();
	void close();
}
