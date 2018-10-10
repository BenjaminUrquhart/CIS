package net.benjaminurquhart.CIS;

import java.io.IOException;
import java.io.InputStream;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.TextChannel;

public class ChannelInputStream extends InputStream {
	
	private Listener listener;
	
	public ChannelInputStream(TextChannel channel, boolean ignoreBots) {
		this.listener = new Listener(channel, ignoreBots);
	}
	
	public ChannelInputStream(MessageChannel channel, Guild guild, boolean ignoreBots) {
		this.listener = new Listener(channel, guild, ignoreBots);
	}
	
	public ChannelInputStream(PrivateChannel channel, boolean ignoreBots) {
		this.listener = new Listener(channel, ignoreBots);
	}
	@Override
	public int available() {
		return listener.available();
	}
	@Override
	public int read() throws IOException {
		try {
			return listener.getNextChar();
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public void close() throws IOException {
		listener.close();
		super.close();
	}
}
