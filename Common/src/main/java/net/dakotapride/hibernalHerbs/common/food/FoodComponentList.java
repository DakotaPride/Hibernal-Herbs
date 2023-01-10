package net.dakotapride.hibernalHerbs.common.food;

public interface FoodComponentList {
    // Base Duration
    int baseDuration = 20;

    // Base Multiplier & Base Chance
    int baseMultiplier = 1;
    float baseChance = 1.0f;

    // Smoked Duration Modifier
    int smokedDurationModifier = 2;
    // Smoked Duration Multiplier
    int smokedMultiplier = baseMultiplier + 1;

    // Effect Durations
    int healthDuration = baseDuration * 30;
    int speedDuration = baseDuration * 40;
    int miningSpeedDuration = baseDuration * 80;
    int visionDuration = baseDuration * 38;
    int damageDuration = baseDuration * 34;
    int glowingDuration = baseDuration * 42;

    // Smoked Effect Durations
    int smokedHealthDuration = healthDuration * smokedDurationModifier;
    int smokedSpeedDuration = speedDuration * smokedDurationModifier;
    int smokedMiningSpeedDuration = miningSpeedDuration * smokedDurationModifier;
    int smokedVisionDuration = visionDuration * smokedDurationModifier;
    int smokedDamageDuration = damageDuration * smokedDurationModifier;
    int smokedGlowingDuration = glowingDuration * smokedDurationModifier;

    // Fire Duration(s)
    // Fabric
    int fireDuration = baseDuration * 26;
    // Smoked (Fabric)
    int smokedFireDuration = fireDuration * smokedDurationModifier;
    // Forge
    int secondsOnFire = 26;
    // Smoked (Forge)
    int smokedSecondsOnFire = secondsOnFire * smokedDurationModifier;

}
