package guicompoundinterest;

public class NominalRate {
            private double PrinAmount;
            private double Time;
            private double FinalAmount;
            private double NumInterest;

            public NominalRate(double PrinAmount, double Time, double FinalAmount, double NumInterest) {
                this.PrinAmount = PrinAmount;
                this.Time = Time;
                this.FinalAmount = FinalAmount;
                this.NumInterest = NumInterest;
            }

            public double getPrinAmount() {
                return PrinAmount;
            }

            public double getTime() {
                return Time;
            }

            public double getFinalAmount() {
                return FinalAmount;
            }

            public double getNumInterest() {
                return NumInterest;
            }
            
            public double calculateFinal(){
                return NumInterest*((Math.pow((FinalAmount/PrinAmount),1/(NumInterest*Time)))-1);
            }
}
