import {PersonalData, RentalOrder} from './rental-order';

describe('PersonalData', () => {

  it('should be initialized correctly', () => {
    let personalDataMeier: PersonalData = new PersonalData('Meier');
    let personalDataHorst: any = {
      name: 'Horst',
      surname: 'Katzmeier'
    };
    personalDataMeier = personalDataHorst;

    let anyObject: any = {
      foo:'bar'
    };

    let rentalOrder: RentalOrder = new RentalOrder();
    rentalOrder.coDriverOption = 'MAYBE';
    console.log('typeof rentalOrder: '+ typeof rentalOrder);

    let rentalOrderRaw: any = {
      personalData:{
        name: 'Horst',
        surname: 'Katzmeier'
      },
      coDriverOption: 'Maybe',
      adacMember: false,
      processData: 'STATUS_OK'
    }
    rentalOrder = anyObject;
    console.log('typeof rentalOrder: '+ typeof rentalOrder);


    console.log(personalDataMeier.name + ' ' +personalDataMeier.surname);
  });
});
