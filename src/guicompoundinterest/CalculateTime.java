package guicompoundinterest;

public class CalculateTime {

            private double PrinAmount;
            private double FinalAmount;
            private double NomRate;
            private double NumInterest;

            public CalculateTime(double PrinAmount, double FinalAmount, double NomRate, double NumInterest) {
                this.PrinAmount = PrinAmount;
                this.FinalAmount = FinalAmount;
                this.NomRate = NomRate;
                this.NumInterest = NumInterest;
            }

            public double getPrinAmount() {
                return PrinAmount;
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
            
            public double calculateTime(){
                return Math.log(FinalAmount / PrinAmount) / (NumInterest * Math.log(1 + (NomRate / NumInterest)));
            }
        }
