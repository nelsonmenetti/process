package com.br.jty.process.entity;

import java.util.List;
import java.util.Map;

import com.br.jty.process.entity.execution.Message;
import com.br.jty.process.entity.execution.Process;

public class MessageBox {

	Map<List<Message>,Process> messagesPerProcess;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((messagesPerProcess == null) ? 0 : messagesPerProcess
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageBox other = (MessageBox) obj;
		if (messagesPerProcess == null) {
			if (other.messagesPerProcess != null)
				return false;
		} else if (!messagesPerProcess.equals(other.messagesPerProcess))
			return false;
		return true;
	}
	
}
