public class TestElectricityBill {
    public static void main(String[] args) {
        System.out.println("Testing Electricity Bill Calculator:");
        
        // Test case 1: 100 units (Tier 1)
        double result1 = ElectricityBillCalculator.calculateElectricityBill(100);
        System.out.printf("100 units: %.2f THB (Expected: 400.00 THB)\n", result1);
        
        // Test case 2: 150 units (Tier 1 max)
        double result2 = ElectricityBillCalculator.calculateElectricityBill(150);
        System.out.printf("150 units: %.2f THB (Expected: 575.00 THB)\n", result2);
        
        // Test case 3: 200 units (Tier 1 + Tier 2)
        double result3 = ElectricityBillCalculator.calculateElectricityBill(200);
        System.out.printf("200 units: %.2f THB (Expected: 785.00 THB)\n", result3);
        
        // Test case 4: 400 units (Tier 1 + Tier 2)
        double result4 = ElectricityBillCalculator.calculateElectricityBill(400);
        System.out.printf("400 units: %.2f THB (Expected: 1,835.00 THB)\n", result4);
        
        // Test case 5: 500 units (Tier 1 + Tier 2 + Tier 3)
        double result5 = ElectricityBillCalculator.calculateElectricityBill(500);
        System.out.printf("500 units: %.2f THB (Expected: 2,335.00 THB)\n", result5);
        
        // Verification calculations:
        System.out.println("\nVerification Calculations:");
        System.out.println("100 units: (100 × 3.50) + 50 = 350 + 50 = 400.00 THB");
        System.out.println("150 units: (150 × 3.50) + 50 = 525 + 50 = 575.00 THB");
        System.out.println("200 units: (150 × 3.50) + (50 × 4.20) + 50 = 525 + 210 + 50 = 785.00 THB");
        System.out.println("400 units: (150 × 3.50) + (250 × 4.20) + 50 = 525 + 1050 + 50 = 1,825.00 THB");
        System.out.println("500 units: (150 × 3.50) + (250 × 4.20) + (100 × 5.00) + 50 = 525 + 1050 + 500 + 50 = 2,125.00 THB");
    }
}