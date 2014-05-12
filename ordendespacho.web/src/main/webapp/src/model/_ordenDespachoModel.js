define([], function() {
    App.Model._OrdenDespachoModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : '' ,  
		 'fecha' : '' ,  
		 'cantidad' : '' ,  
		 'estado' : ''        },
        initialize: function() {
        },
        getDisplay: function(name) {
             if(name=='fecha'){
                   var dateConverter = App.Utils.Converter.date;
                   return dateConverter.unserialize(this.get('fecha'), this);
             }
         return this.get(name);
        }
    });

    App.Model._OrdenDespachoList = Backbone.Collection.extend({
        model: App.Model._OrdenDespachoModel,
        initialize: function() {
        }

    });
    return App.Model._OrdenDespachoModel;
});