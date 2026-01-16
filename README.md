# โปรแกรมคำนวณค่าไฟฟ้า / Electricity Bill Calculator

## รายละเอียดโปรแกรม / Program Details

โปรแกรมนี้ใช้สำหรับคำนวณค่าไฟฟ้าตามหน่วยการใช้งาน (kWh) โดยใช้ระบบเรตแบบลำดับชั้นตามอัตราที่กำหนด

This program calculates electricity bills based on consumption units (kWh) using a tiered rate system according to the specified rates.

## อัตราค่าไฟฟ้า / Electricity Rates

- 0-150 หน่วย: 3.50 บาท/หน่วย
- 151-400 หน่วย: 4.20 บาท/หน่วย
- 401 หน่วยขึ้นไป: 5.00 บาท/หน่วย
- ค่าบริการ: 50 บาท (คงที่)

- 0-150 units: 3.50 THB/unit
- 151-400 units: 4.20 THB/unit
- 401 units and above: 5.00 THB/unit
- Service fee: 50 THB (fixed)

## Pseudocode (ภาษาไทย)

```
เริ่มต้นโปรแกรม
กำหนดค่าคงที่:
  - RATE_TIER_1 = 3.50 (อัตราชั้นที่ 1)
  - RATE_TIER_2 = 4.20 (อัตราชั้นที่ 2)
  - RATE_TIER_3 = 5.00 (อัตราชั้นที่ 3)
  - SERVICE_FEE = 50.00 (ค่าบริการคงที่)

แสดงข้อความต้อนรับ
รับค่าหน่วยการใช้งานไฟฟ้าจากผู้ใช้ (units)

ถ้า units < 0 แล้ว
  แสดงข้อความ "จำนวนหน่วยต้องไม่เป็นลบ"
  จบโปรแกรม
จบถ้า

ถ้า units <= 0 แล้ว
  คืนค่า 0.0
ไม่เช่นนั้น ถ้า units <= 150 แล้ว
  คำนวณ totalBill = units * RATE_TIER_1
ไม่เช่นนั้น ถ้า units <= 400 แล้ว
  คำนวณ totalBill = (150 * RATE_TIER_1) + ((units - 150) * RATE_TIER_2)
ไม่เช่นนั้น
  คำนวณ totalBill = (150 * RATE_TIER_1) + (250 * RATE_TIER_2) + ((units - 400) * RATE_TIER_3)
จบถ้า

เพิ่มค่า SERVICE_FEE เข้ากับ totalBill
แสดงผลรวมค่าไฟฟ้าและรายละเอียดการคิดเงิน
จบโปรแกรม
```

## Pseudocode (English)

```
Start program
Define constants:
  - RATE_TIER_1 = 3.50 (rate for tier 1)
  - RATE_TIER_2 = 4.20 (rate for tier 2)
  - RATE_TIER_3 = 5.00 (rate for tier 3)
  - SERVICE_FEE = 50.00 (fixed service fee)

Display welcome message
Get electricity consumption units from user (units)

If units < 0 Then
  Display "Units must not be negative"
  End program
End If

If units <= 0 Then
  Return 0.0
Else If units <= 150 Then
  Calculate totalBill = units * RATE_TIER_1
Else If units <= 400 Then
  Calculate totalBill = (150 * RATE_TIER_1) + ((units - 150) * RATE_TIER_2)
Else
  Calculate totalBill = (150 * RATE_TIER_1) + (250 * RATE_TIER_2) + ((units - 400) * RATE_TIER_3)
End If

Add SERVICE_FEE to totalBill
Display total electricity cost and billing details
End program
```

## วิธีการใช้งาน / How to Use

1. คอมไพล์โปรแกรมโดยใช้คำสั่ง: `javac ElectricityBillCalculator.java`
2. รันโปรแกรมโดยใช้คำสั่ง: `java ElectricityBillCalculator`
3. ป้อนจำนวนหน่วยการใช้งานไฟฟ้า (kWh) ที่ต้องการคำนวณ
4. โปรแกรมจะแสดงรายละเอียดการคิดเงินและค่าไฟฟ้ารวม

## How to Use

1. Compile the program using: `javac ElectricityBillCalculator.java`
2. Run the program using: `java ElectricityBillCalculator`
3. Enter the electricity consumption units (kWh) you want to calculate
4. The program will display billing details and the total electricity cost