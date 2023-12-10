export interface ExerciseTraining {
    id: string
}

export enum BodyPart {
    NECK,
    CHEST,
    DELTOIDS,
    ABS,
    BICEPS,
    TRICEPS,
    FOREARMS,
    GRIP,
    BOTTOM,
    LEGS,
    UPPER_BACK,
    LATS,
    LOWER_BACK
}

export interface Exercise {
    id: string,
    name: string,
    bodyPart: BodyPart,
    difficulty: number,
    description: string,
    training: ExerciseTraining
}
