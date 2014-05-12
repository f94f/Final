define([], function() {
    App.Model._ItemModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : '' ,  
		 'fechaCaducidad' : '' ,  
		 'reservado' :  false  ,  
		 'motivoIngreso' : '' ,  
		 'motivoSalid' : '' ,  
		 'enBodega' :  false         },
        initialize: function() {
        },
        getDisplay: function(name) {
             if(name=='fechaCaducidad'){
                   var dateConverter = App.Utils.Converter.date;
                   return dateConverter.unserialize(this.get('fechaCaducidad'), this);
             }
         return this.get(name);
        }
    });

    App.Model._ItemList = Backbone.Collection.extend({
        model: App.Model._ItemModel,
        initialize: function() {
        }

    });
    return App.Model._ItemModel;
});