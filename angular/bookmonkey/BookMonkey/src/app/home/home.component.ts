import {Component, OnInit} from '@angular/core';
import {Fitness, FitnessAspect, FitnessLevel, FitnessStudioMember} from '../shared/fitness-studio';
import {createFitnessCalculator, FitnessCalculator} from '../shared/fitness-calculator';

@Component({
  selector: 'bm-home',
  template: `
    <div class="ui container">
      <h1>Home</h1>
      <p>Das ist der BookMonkey.</p>
      <a routerLink="../books" class="ui red button">
        Buchliste ansehen
        <i class="right arrow icon"></i>
      </a>
    </div>
  `
})
export class HomeComponent implements OnInit {


  ngOnInit(): void {

  }

  doSomeTests(): void {
    let marco: FitnessStudioMember = new FitnessStudioMember('Marco', 'Bernasconi', 46, 83, 1.88);
    let fitnessCategories: Fitness[] = new Array();
    fitnessCategories.push(new Fitness(FitnessAspect.BMI, FitnessLevel.FIT));
    marco.fitnessCategories = fitnessCategories;

    let bmi: Fitness = marco.getFitnessByAspect(FitnessAspect.BODY_FAT);


    let anyObject = {
      prop1: 'property 1',
      prop2: 'property 2',
      prop3: 'property 3'
    };

    // for (let o of anyObject) {
    //   console.log(o);
    // }

    let fitnessValues = Object.values(FitnessAspect).filter(value => isNaN(value));
    for(let val of fitnessValues){
      console.log(val);
    }


    let calculateBmi = createFitnessCalculator(FitnessAspect.BMI);
    let fitness: Fitness = calculateBmi(marco);

    console.table(fitness);

    console.log('Marco is '+FitnessLevel[fitness.level]);

  }
}
