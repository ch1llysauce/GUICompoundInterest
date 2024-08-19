package guicompoundinterest;

public class PrincipalAmount {
            private double Time;
            private double FinalAmount;
            private double NomRate;
            private double NumInterest;

            public PrincipalAmount(double Time, double FinalAmount, double NomRate, double NumInterest) {
                this.Time = Time;
                this.FinalAmount = FinalAmount;
                this.NomRate = NomRate;
                this.NumInterest = NumInterest;
            }

            public double getTime() {
                return Time;
            }

            public double getFinalAmount() {
                return FinalAmount;
            }

            public double getNomRate() {
                return NomRate;
            }

            public double getNumInterest() {
                return NumInterest;
            }
            
            public double calculatePrin(){
                return FinalAmount/Math.pow((1+(NomRate)/(NumInterest)), NomRate*Time);
            } 
}
