export interface Exercise {
    id: string;
    name: string;
    trainingId: string;
}

export interface Exercises {
    exercises: Exercise[];
}
