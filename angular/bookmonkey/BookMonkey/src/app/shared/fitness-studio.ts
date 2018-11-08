import {Person} from './person';

export class FitnessStudioMember extends Person {

  private _totalFitnessLevel: FitnessLevel;

  private _fitnessCategories: Fitness[];


  constructor(name: string, surname: string, age?: number, private readonly _weight?: number, private readonly _height?: number) {
    super(name, surname, age);
  }

  get height(): number {
    return this._height;
  }

  get weight(): number {
    return this._weight;
  }

  get totalFitnessLevel(): FitnessLevel {
    return this._totalFitnessLevel;
  }

  set totalFitnessLevel(value: FitnessLevel) {
    this._totalFitnessLevel = value;
  }

  get fitnessCategories(): Fitness[] {
    return this._fitnessCategories;
  }

  set fitnessCategories(value: Fitness[]) {
    this._fitnessCategories = value;
  }

  getFitnessByAspect(aspect: FitnessAspect): Fitness{
    if(this._fitnessCategories){
      let fitness: Fitness[] = this._fitnessCategories.filter((f) => f.aspect === aspect);
      if(fitness.length > 0){
        return fitness[0];
      }
    }
    // TODO omit or return null??
    // return null;

  }
}

export class FitnessStudio {

  constructor(private readonly _name: string) {
  }

  get name(): string {
    return this._name;
  }
}

export enum FitnessLevel {
  UNFIT,
  NOT_SO_FIT,
  FIT,
  VERY_FIT
}

export enum FitnessAspect {
  BMI,
  BODY_FAT,
  STRENGTH
}

export class Fitness {

  constructor(private readonly _aspect: FitnessAspect, private readonly _level: FitnessLevel) {
    this._aspect = _aspect;
    this._level = _level;
  }

  get aspect(): FitnessAspect {
    return this._aspect;
  }

  get level(): FitnessLevel {
    return this._level;
  }
}
