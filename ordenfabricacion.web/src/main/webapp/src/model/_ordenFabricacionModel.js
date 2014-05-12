define([], function() {
    App.Model._OrdenFabricacionModel = Backbone.Model.extend({
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

    App.Model._OrdenFabricacionList = Backbone.Collection.extend({
        model: App.Model._OrdenFabricacionModel,
        initialize: function() {
        }

    });
    return App.Model._OrdenFabricacionModel;
});