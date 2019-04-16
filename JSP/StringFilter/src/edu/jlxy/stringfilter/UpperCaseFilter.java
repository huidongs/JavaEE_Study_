package edu.jlxy.stringfilter;

public class UpperCaseFilter implements IFilter {

	private String name = "´óÐ´×ª»»Æ÷";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String filter(String text) {
		return text.toUpperCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		UpperCaseFilter other = (UpperCaseFilter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return getName();
	}


}
