define([], function() {
    App.Model._OrdenReaprovicionamientoModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : '' ,  
		 'fecha' : '' ,  
		 'cantidad' : ''        },
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

    App.Model._OrdenReaprovicionamientoList = Backbone.Collection.extend({
        model: App.Model._OrdenReaprovicionamientoModel,
        initialize: function() {
        }

    });
    return App.Model._OrdenReaprovicionamientoModel;
});