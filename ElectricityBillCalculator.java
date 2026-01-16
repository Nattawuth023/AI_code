import java.util.Scanner;

public class ElectricityBillCalculator {
    
    // Constants for the electricity rates
    private static final double RATE_TIER_1 = 3.50;    // 0-150 units
    private static final double RATE_TIER_2 = 4.20;    // 151-400 units
    private static final double RATE_TIER_3 = 5.00;    // 401+ units
    private static final double SERVICE_FEE = 50.00;   // Fixed service fee
    
    /**
     * Calculates the electricity bill based on consumption units
     * @param units The number of kWh consumed
     * @return The total electricity bill amount in THB
     */
    public static double calculateElectricityBill(double units) {
        double totalBill = 0.0;
        
        if (units <= 0) {
            return 0.0;
        }
        
        // Calculate for Tier 1 (0-150 units)
        if (units <= 150) {
            totalBill = units * RATE_TIER_1;
        } else {
            totalBill = 150 * RATE_TIER_1;
            
            // Calculate for Tier 2 (151-400 units)
            if (units <= 400) {
                totalBill += (units - 150) * RATE_TIER_2;
            } else {
                totalBill += (400 - 150) * RATE_TIER_2;
                
                // Calculate for Tier 3 (401+ units)
                totalBill += (units - 400) * RATE_TIER_3;
            }
        }
        
        // Add the fixed service fee
        totalBill += SERVICE_FEE;
        
        return totalBill;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== โปรแกรมคำนวณค่าไฟฟ้า ===");
        System.out.print("กรุณาป้อนจำนวนหน่วยการใช้งานไฟฟ้า (kWh): ");
        
        try {
            double consumption = scanner.nextDouble();
            
            if (consumption < 0) {
                System.out.println("จำนวนหน่วยต้องไม่เป็นลบ");
                return;
            }
            
            double billAmount = calculateElectricityBill(consumption);
            
            System.out.println("\n--- รายละเอียดการคำนวณ ---");
            System.out.printf("จำนวนหน่วยที่ใช้: %.2f kWh\n", consumption);
            System.out.printf("ค่าไฟฟ้า: %.2f บาท\n", billAmount - SERVICE_FEE);
            System.out.printf("ค่าบริการ: %.2f บาท\n", SERVICE_FEE);
            System.out.printf("รวมทั้งสิ้น: %.2f บาท\n", billAmount);
            
            // Show breakdown for educational purposes
            showRateBreakdown(consumption);
            
        } catch (Exception e) {
            System.out.println("ข้อมูลที่ป้อนไม่ถูกต้อง กรุณาป้อนตัวเลข");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Shows the breakdown of charges based on consumption tiers
     * @param units The number of kWh consumed
     */
    public static void showRateBreakdown(double units) {
        System.out.println("\n--- การคำนวณตามช่วงอัตรา ---");
        
        if (units <= 0) {
            System.out.println("ไม่มีการใช้งาน");
            return;
        }
        
        if (units <= 150) {
            System.out.printf("0-150 หน่วย @ %.2f บาท/หน่วย: %.2f บาท\n", 
                             RATE_TIER_1, units * RATE_TIER_1);
        } else {
            System.out.printf("0-150 หน่วย @ %.2f บาท/หน่วย: %.2f บาท\n", 
                             RATE_TIER_1, 150 * RATE_TIER_1);
            
            if (units <= 400) {
                System.out.printf("151-%.0f หน่วย @ %.2f บาท/หน่วย: %.2f บาท\n", 
                                 units, RATE_TIER_2, (units - 150) * RATE_TIER_2);
            } else {
                System.out.printf("151-400 หน่วย @ %.2f บาท/หน่วย: %.2f บาท\n", 
                                 RATE_TIER_2, (400 - 150) * RATE_TIER_2);
                System.out.printf("401-%.0f หน่วย @ %.2f บาท/หน่วย: %.2f บาท\n", 
                                 units, RATE_TIER_3, (units - 400) * RATE_TIER_3);
            }
        }
    }
}