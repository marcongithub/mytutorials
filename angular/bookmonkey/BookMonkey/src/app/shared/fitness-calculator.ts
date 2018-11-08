import {Fitness, FitnessAspect, FitnessLevel, FitnessStudioMember} from './fitness-studio';

export interface FitnessCalculator {

  (person: FitnessStudioMember): Fitness;

}


export function createFitnessCalculator(aspect: FitnessAspect): FitnessCalculator {
  console.log('in create');
  let calculator: FitnessCalculator;
  switch (aspect) {
    case FitnessAspect.BMI:
      calculator = bmiCalculation;
      break;
    case FitnessAspect.BODY_FAT:
      break;
    case FitnessAspect.STRENGTH:
      ;
    default:
      ;

  }
  return calculator;

}

function bmiCalculation(person: FitnessStudioMember): Fitness {
  let bmi: number = person.weight / (person.height * person.height);
  console.log('************ BMI: ' + bmi);
  let fitnessLevel: FitnessLevel;
  if (bmi < 20 || bmi > 35) {
    fitnessLevel = FitnessLevel.UNFIT;
  } else if (bmi >= 20 && bmi < 25) {
    fitnessLevel = FitnessLevel.VERY_FIT;
  } else if (bmi >= 25 && bmi < 30) {
    fitnessLevel = FitnessLevel.FIT;
  } else {
    fitnessLevel = FitnessLevel.NOT_SO_FIT;
  }
  let fitness: Fitness = new Fitness(FitnessAspect.BMI, fitnessLevel);
  return fitness;
}



