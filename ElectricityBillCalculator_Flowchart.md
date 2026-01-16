```mermaid
flowchart TD
    A[Start] --> B[Initialize constants: RATE_TIER_1=3.50, RATE_TIER_2=4.20, RATE_TIER_3=5.00, SERVICE_FEE=50.00]
    B --> C[Display welcome message]
    C --> D[Prompt user for electricity consumption units]
    D --> E[Read input consumption units]
    E --> F[Check if units < 0]
    F -->|Yes| G[Display error: Units cannot be negative]
    G --> H[End]
    F -->|No| I[Initialize totalBill = 0]
    I --> J[Check if units <= 0]
    J -->|Yes| K[Return 0.0]
    J -->|No| L[Check if units <= 150]
    L -->|Yes| M[totalBill = units * RATE_TIER_1]
    L -->|No| N[totalBill = 150 * RATE_TIER_1]
    M --> O[Add SERVICE_FEE to totalBill]
    N --> P[Check if units <= 400]
    P -->|Yes| Q[totalBill = totalBill + (units - 150) * RATE_TIER_2]
    P -->|No| R[totalBill = totalBill + (400 - 150) * RATE_TIER_2]
    Q --> O
    R --> S[totalBill = totalBill + (units - 400) * RATE_TIER_3]
    S --> O
    K --> W[End]
    O --> T[Display calculated bill amount]
    T --> U[Show rate breakdown]
    U --> V[End]
```

## Flowchart Description for Electricity Bill Calculator

The program follows these main steps:

1. **Initialization**: Set up constants for the different rate tiers and service fee
2. **Input**: Prompt user for electricity consumption in kWh
3. **Validation**: Check if the input is valid (non-negative)
4. **Calculation**: Apply the tiered rate system:
   - Tier 1: First 150 units at 3.50 THB/unit
   - Tier 2: 151-400 units at 4.20 THB/unit
   - Tier 3: Above 401 units at 5.00 THB/unit
5. **Service Fee**: Add the fixed service fee of 50 THB
6. **Output**: Display the total bill amount and breakdown