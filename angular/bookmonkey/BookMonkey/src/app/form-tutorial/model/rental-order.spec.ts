import {PersonalData, RentalOrder} from './rental-order';

describe('PersonalData', () => {

  it('should display date correctly', () => {

    // birthDate: '2018-07-22' expected format for dates YYYY-mm-dd
    let anyDate: Date = new Date();
    // other formats
    console.log('anyDate toLocaleDateString(): '+anyDate.toLocaleDateString());
    console.log('anyDate toDateString(): '+anyDate.toDateString());
    console.log('anyDate toLocaleTimeString(): '+anyDate.toLocaleTimeString());

    // GMT, resp UTC timezone 0!
    // console.log('anyDate,  time: '+anyDate.toISOString().split('T')[1]);
    console.log('anyDate iso: ' + anyDate.toISOString());
    let dateAsString = new Date(anyDate.getTime() - (anyDate.getTimezoneOffset() * 60000))
      .toISOString()
      .split('T')[0];
    console.log('anyDate with timezone as string: ' + dateAsString);
    console.log('anyDate time: ' + new Date(anyDate.getTime() - (anyDate.getTimezoneOffset() * 60000))
      .toISOString()
      .split('T')[1]);

    // convert back
    let split: Number[] = dateAsString.split('-').map(s => Number(s));
    let convertedBack: Date  = new Date(split[0],(split[1]-1),split[2]);

    console.log('converted back... '+new Date(convertedBack.getTime() - (convertedBack.getTimezoneOffset() * 60000))
      .toISOString()
      .split('T')[0]);



  });

  it('should be initialized correctly', () => {
    let personalDataMeier: PersonalData = new PersonalData('Meier');
    let personalDataHorst: any = {
      name: 'Horst',
      surname: 'Katzmeier'
    };
    personalDataMeier = personalDataHorst;

    let anyObject: any = {
      foo: 'bar'
    };

    let rentalOrder: RentalOrder = new RentalOrder();
    rentalOrder.coDriverOption = 'MAYBE';
    console.log('typeof rentalOrder: ' + typeof rentalOrder);

    let rentalOrderRaw: any = {
      personalData: {
        name: 'Horst',
        surname: 'Katzmeier'
      },
      coDriverOption: 'Maybe',
      adacMember: false,
      processData: 'STATUS_OK'
    };
    rentalOrder = anyObject;
    console.log('typeof rentalOrder: ' + typeof rentalOrder);


    console.log(personalDataMeier.name + ' ' + personalDataMeier.surname);
  });
});
