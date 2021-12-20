function myFunction() 
{
  let counter=1;
  let maxval=Number.NEGATIVE_INFINITY;
  while(counter<=10)
  {
	let num=parseInt(prompt("Enter units sold by person "+counter));
	counter+=1;
	if(num>maxval)
	{
		maxval=num;
	}
  }
    document.getElementById("output").innerHTML = "The largest value is: "+maxval;
}
