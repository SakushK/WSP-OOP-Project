package project;

import java.io.Serializable;
import java.util.Objects;

public class Mark implements Serializable {
    public double FirstAtt, SecondAtt,FinalExam;
    public Mark() {
    	
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(FinalExam, FirstAtt, SecondAtt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return Double.doubleToLongBits(FinalExam) == Double.doubleToLongBits(other.FinalExam)
				&& Double.doubleToLongBits(FirstAtt) == Double.doubleToLongBits(other.FirstAtt)
				&& Double.doubleToLongBits(SecondAtt) == Double.doubleToLongBits(other.SecondAtt);
	}

	@Override
	public String toString() {
		return "Mark [FirstAtt=" + FirstAtt + ", SecondAtt=" + SecondAtt + ", FinalExam=" + FinalExam + "]";
	}
    
}
