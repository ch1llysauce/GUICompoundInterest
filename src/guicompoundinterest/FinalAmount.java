package guicompoundinterest;

public class FinalAmount {
            private double PrinAmount;
            private double Time;
            private double NomRate;
            private double NumInterest;

            public FinalAmount(double PrinAmount, double Time, double NomRate, double NumInterest) {
                this.PrinAmount = PrinAmount;
                this.Time = Time;
                this.NomRate = NomRate;
                this.NumInterest = NumInterest;
            }

            public double getPrinAmount() {
                return PrinAmount;
            }

            public double getTime() {
                return Time;
            }

            public double getNomRate() {
                return NomRate;
            }

            public double getNumInterest() {
                return NumInterest;
            }
            
            public double calculateFinal(){
                return PrinAmount*Math.pow((1+(NomRate/NumInterest)), NumInterest*Time);
            }
}
