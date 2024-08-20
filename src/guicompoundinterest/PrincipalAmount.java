package guicompoundinterest;

public class PrincipalAmount {
            private double Time;
            private double FinalAmount;
            private double NomRate;
            private double NumInterest;

            public PrincipalAmount(double FinalAmount, double Time , double NomRate, double NumInterest) {
                this.Time = Time;
                this.FinalAmount = FinalAmount;
                this.NomRate = NomRate;
                this.NumInterest = NumInterest;
            }

            public double getFinalAmount() {
                return FinalAmount;
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
            
            public double calculatePrin(){
                return FinalAmount/Math.pow((1+(NomRate/NumInterest)), (NumInterest*Time));
            } 
}
