$('select[data-value]').each(function(index, el){
	const $el = $(el);
	const newData = $el.attr('data-value').trim();
	console.log(newData)
	
	if(newData.length > 0) $el.val(newData);
})
